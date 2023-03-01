package com.walletapp;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class CollectionWalletRepositoryImpl implements CollectionWalletRepository {
    private Map<Integer,WalletDto> map=new HashMap<>();
    @Override
    public WalletDto createWallet(WalletDto newWallet) {
        map.put(newWallet.getId(),newWallet);
        return newWallet;
    }

    @Override
    public WalletDto getWalletById(Integer walletId) throws WalletException{
        if(map.get(walletId)==null)
            throw new WalletException("Wallet with id:"+walletId+" doesn't exist");
        return map.get(walletId);
    }

    @Override
    public WalletDto updateWallet(WalletDto wallet) throws WalletException{
        if(map.replace(wallet.getId(), wallet)==null)
            throw new WalletException("there is no wallet with id:"+wallet.getId()+" to update");
        return wallet;
    }

    @Override
    public WalletDto deleteWalletById(Integer walletId)throws WalletException {
        if(!map.containsKey(walletId))
            throw new WalletException("there is no wallet with id:"+walletId+" to delete");
        return map.remove(walletId);
    }
    @Override
    public List<WalletDto> getAllWallets() {
        List<WalletDto> list=new ArrayList<>();
        for(Map.Entry<Integer,WalletDto> entry: map.entrySet())
        {
            list.add(entry.getValue());
        }
        return list;
    }

}
