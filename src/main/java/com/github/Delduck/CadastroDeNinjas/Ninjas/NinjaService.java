package com.github.Delduck.CadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::ninjaModeltoDTO)
                .toList();
    }

    public NinjaDTO listarNinjasId(Long id) {
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.map(ninjaMapper::ninjaModeltoDTO).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.ninjaDTOtoModel(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);

        return ninjaMapper.ninjaModeltoDTO(ninjaModel);
    }

    public void deletarNinjasID(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.ninjaDTOtoModel(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.ninjaModeltoDTO(ninjaSalvo);
        }
        return null;
    }
}
