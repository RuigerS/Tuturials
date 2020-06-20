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
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;

public class MainV3 {

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

//            // Get the latest nonce
//            EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
//            BigInteger nonce =  ethGetTransactionCount.getTransactionCount();
//
//            // Recipient address
//            String recipientAddress = "0x960344cE81648AB5677618a6E3F00365Cf808c3a";
//
//            // Value to transfer (in wei)
//            BigInteger value = Convert.toWei("1", Unit.ETHER).toBigInteger();
//
//            // Gas Parameters
//            BigInteger gasLimit = BigInteger.valueOf(21000);
//            BigInteger gasPrice = Convert.toWei("1", Unit.GWEI).toBigInteger();
//
//            // Prepare the rawTransaction
//            RawTransaction rawTransaction  = RawTransaction.createEtherTransaction(
//                    nonce,
//                    gasPrice,
//                    gasLimit,
//                    recipientAddress,
//                    value);
//
//            // Sign the transaction
//            byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
//            String hexValue = Numeric.toHexString(signedMessage);
//
//            // Send transaction
//            EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();
//            String transactionHash = ethSendTransaction.getTransactionHash();
//            System.out.println("transactionHash: " + transactionHash);
//
//            // Wait for transaction to be mined
//            Optional<TransactionReceipt> transactionReceipt = null;
//            do {
//                System.out.println("checking if transaction " + transactionHash + " is mined....");
//                EthGetTransactionReceipt ethGetTransactionReceiptResp = web3.ethGetTransactionReceipt(transactionHash).send();
//                transactionReceipt = ethGetTransactionReceiptResp.getTransactionReceipt();
//                Thread.sleep(3000); // Wait 3 sec
//            } while(!transactionReceipt.isPresent());

            BigInteger gasPrice = new BigInteger("20000000000");
            BigInteger gasLimit = new BigInteger("6721975");

            System.out.println("set gas Price: " + gasPrice.toString());
            System.out.println("set gas Limit: " + gasLimit.toString());

            DocumentRegistry registryContract = DocumentRegistry.deploy(web3, credentials, gasPrice, gasLimit).send();

            String contractAddress = registryContract.getContractAddress();

            System.out.println("Deployed to " + contractAddress.toString());

            ContractGasProvider gasProvider = new DefaultGasProvider();
            System.out.println("default gas Price: " + gasProvider.getGasPrice("wei"));
            System.out.println("default gas Limit: " + gasProvider.getGasLimit("wei"));


            DocumentRegistry registryContract2 = DocumentRegistry.load(contractAddress, web3, credentials, gasPrice, gasLimit );

            TransactionReceipt receipt = registryContract2.notarizeDocument("QmXoypizjW3WknFiJnKLwHCnL72vedxjQkDDP1mXWo6uco").send();
            System.out.println("Notarized with hash " + receipt.getTransactionHash());

            Boolean goodTrip = registryContract2.isNotarized("QmXoypizjW3WknFiJnKLwHCnL72vedxjQkDDP1mXWo6uco").send();


//
//            String txHash = receipt.getTransactionHash();
            registryContract
                    .notarizedEventFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                    .subscribe(event -> {
                        final String notary = event._signer;
                        final String documentHash = event._documentHash;

                        //Perform processing based on event values
                        System.out.println("notary "+ notary + "\nhash "+documentHash);
                    });

        } catch (IOException | InterruptedException ex) {
            System.out.println("transactionHash: " + ex.getMessage());
            throw new RuntimeException(ex);
        } catch (Exception e) {
            System.out.println("transactionHash: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
