package projekt2.SpravcePortfolia.controller;

import org.springframework.web.bind.annotation.*;
import projekt2.SpravcePortfolia.model.Crypto;
import projekt2.SpravcePortfolia.service.CryptoService;

import java.util.List;


@RestController
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @PostMapping("/cryptos")
    public void addCrypto(@RequestBody Crypto newCrypto) {
        cryptoService.addCrypto(newCrypto);
    }

    @GetMapping("/cryptos")
    public List<Crypto> getAllCryptos(
            @RequestParam(required = false) String sort
    ) {
        if (sort == null) {
            return cryptoService.getAllCrypto();
        }

        return switch (sort) {
            case "name" -> cryptoService.sortByName();
            case "price" -> cryptoService.sortByPrice();
            case "quantity" -> cryptoService.sortByQuantity();
            default -> cryptoService.getAllCrypto();
        };
    }

    @GetMapping("/cryptos/{id}")
    public Crypto getCryptoById(@PathVariable Integer id) {
            return cryptoService.getCryptoById(id);
    }


}
