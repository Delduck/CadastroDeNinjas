package com.github.Delduck.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

}
