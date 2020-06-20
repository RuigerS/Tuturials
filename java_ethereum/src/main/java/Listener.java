import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;

public class Listener {
    public static void main(String[] args) {
        Web3j web3j = Web3j.build(new HttpService("http://localhost:7545"));

//Deploys a notary contract via wrapper
//        final Notary notaryContract = deployNotaryContract(web3j);
//
//        notaryContract
//                .notarizedEventFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
//                .subscribe(event -> {
//                    final String notary = event.notary;
//                    final String documentHash = event.documentHash;
//
//                    //Perform processing based on event values
//                });
    }
}
