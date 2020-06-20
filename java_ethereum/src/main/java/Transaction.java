// Transaction.java
package io.kauri.tutorials.java_ethereum;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Optional;

import me.gjeanmart.tutorials.javaethereum.contracts.generated.DocumentRegistry;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;


public class Transaction {
    public static void main(String[] args)  {


        System.out.println("Connecting to Ethereum ...");
        Web3j web3 = Web3j.build(new HttpService("http://localhost:7545"));
        System.out.println("Successfuly connected to Ethereum");

        try {
            String pk = "4670fc10b2f63153baf006f66ac612d2235b20c6a8465bc3d4765f976bf0ef79"; // Add a private key here

            // Decrypt and open the wallet into a Credential object
            Credentials credentials = Credentials.create(pk);
            System.out.println("Account address: " + credentials.getAddress());
            System.out.println("Balance: " + Convert.fromWei(web3.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send().getBalance().toString(), Unit.ETHER));

            // Get the latest nonce
            EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
            BigInteger nonce =  ethGetTransactionCount.getTransactionCount();

            // Recipient address
            String recipientAddress = "0x4BDfE273171F5EDa2Fdf8AAfc1218375a3e2bCdc";

            // Value to transfer (in wei)
            BigInteger value = Convert.toWei("1", Unit.ETHER).toBigInteger();

            // Gas Parameters
            BigInteger gasLimit = BigInteger.valueOf(21000);
            BigInteger gasPrice = Convert.toWei("1", Unit.GWEI).toBigInteger();

            // Prepare the rawTransaction
            RawTransaction rawTransaction  = RawTransaction.createEtherTransaction(
                    nonce,
                    gasPrice,
                    gasLimit,
                    recipientAddress,
                    value);

            // Sign the transaction
            byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
            String hexValue = Numeric.toHexString(signedMessage);

            // Send transaction
            EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();
            String transactionHash = ethSendTransaction.getTransactionHash();
            System.out.println("transactionHash: " + transactionHash);

            // Wait for transaction to be mined
            Optional<TransactionReceipt> transactionReceipt = null;
            do {
                System.out.println("checking if transaction " + transactionHash + " is mined....");
                EthGetTransactionReceipt ethGetTransactionReceiptResp = web3.ethGetTransactionReceipt(transactionHash).send();
                transactionReceipt = ethGetTransactionReceiptResp.getTransactionReceipt();
                Thread.sleep(3000); // Wait 3 sec
            } while(!transactionReceipt.isPresent());

            System.out.println("Transaction " + transactionHash + " was mined in block # " + transactionReceipt.get().getBlockNumber());
            System.out.println("Balance: " + Convert.fromWei(web3.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send().getBalance().toString(), Unit.ETHER));

//            System.out.println("\n\nOpdracht 4");
//            gasLimit = new BigInteger("6721975");
//            gasPrice = new BigInteger("20000000000");
//            Credentials creds = Credentials.create("f5279d9b8188200555471de9d3a7e26422a247879927713faeb6f80ecacad840");
//            DocumentRegistryV2 registryContract2 = DocumentRegistryV2.load(ContractAdress, web3, credentials, gasPrice,gasLimit);
//            Transactionreceipt receipt = registryContract2.notarizeDocument();
//            String contractAddress = registryContract.getContractAddress();
//            //DocumentRegistry registryContract = DocumentRegistry.load(credentials.getAddress(),web3, creds, new DefaultGasProvider());


        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
