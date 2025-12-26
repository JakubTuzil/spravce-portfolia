package projekt2.SpravcePortfolia.service;

import org.springframework.stereotype.Service;
import projekt2.SpravcePortfolia.model.Crypto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CryptoService {

    private List<Crypto> cryptoList = new ArrayList<>();

    public void addCrypto(Crypto newCrypto) {
        cryptoList.add(newCrypto);
    }

    public List<Crypto> getAllCrypto() {
        return new ArrayList<>(cryptoList);
    }

    public List<Crypto> sortByName () {
        return cryptoList.stream()
                .sorted(Comparator.comparing(Crypto::getName))
                .toList();
    }

    public List<Crypto> sortByPrice () {
        return cryptoList.stream()
                .sorted(Comparator.comparing(Crypto::getPrice))
                .toList();
    }

    public List<Crypto> sortByQuantity () {
        return cryptoList.stream()
                .sorted(Comparator.comparing(Crypto::getQuantity))
                .toList();
    }

}
