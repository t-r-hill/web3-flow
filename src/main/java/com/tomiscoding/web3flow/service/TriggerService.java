package com.tomiscoding.web3flow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

@Service
public class TriggerService {

    private final Web3j web3j;

    public TriggerService(){
        web3j = Web3j.build(new HttpService("https://nd-098-531-720.p2pify.com/e461bc3dbd13ddb07fe00afa96737b92"));
    }

    public BigDecimal getEthBalance() {
        EthGetBalance result = new EthGetBalance();
        BigDecimal balanceAsEth = null;
        try {
            result = web3j.ethGetBalance("0x1E8E4445f7736084A48c3cca4Cf3d148EC6CB3fC",
                    DefaultBlockParameter.valueOf("latest"))
                    .sendAsync().get();
            BigInteger balanceAsWei = result.getBalance();
            balanceAsEth = Convert.fromWei(new BigDecimal(balanceAsWei), Convert.Unit.ETHER);
        } catch (Exception ex) {
            System.out.println("Exception from EthGetBalance");
        }
        return balanceAsEth;
    }

    public BigDecimal getGasPrice() {
        EthGasPrice result = new EthGasPrice();
        BigDecimal gasPriceAsGwei = null;
        try {
            result = web3j.ethGasPrice().sendAsync().get();
            BigInteger gasPriceAsWei = result.getGasPrice();
            gasPriceAsGwei = Convert.fromWei(new BigDecimal(gasPriceAsWei), Convert.Unit.GWEI);
        } catch (Exception e) {
            System.out.println();;
        }
        return gasPriceAsGwei;
    }
}
