package bts.sio.api.service;

import bts.sio.api.model.Sport;
import bts.sio.api.repository.SportRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Data
@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;

    public Optional<Sport> getSport(final Long id) {
        return sportRepository.findById(id);
    }

    public Iterable<Sport> getSports() {
        return sportRepository.findAll();
    }

    public void deleteSport(final Long id) {
        sportRepository.deleteById(id);
    }
    public Sport createSport(Sport sport) {
        return saveSport(sport);
    }
    public Optional<Sport> updateSport(Long id, Sport updatedSport) {
        Optional<Sport> existingSport = getSport(id);
        if (existingSport.isPresent()) {
            Sport sportToUpdate = existingSport.get();
            sportToUpdate.setNom(updatedSport.getNom());
            sportToUpdate.setDescriptif(updatedSport.getDescriptif());
            sportToUpdate.setOlympiade(updatedSport.getOlympiade()); // si vous modifiez aussi l'olympiade
            return Optional.of(saveSport(sportToUpdate));
        }
        return Optional.empty(); // Retourner un Optional vide si le sport n'existe pas
    }
    public Sport saveSport(Sport sport) {
        Sport savedSport = sportRepository.save(sport);
        return savedSport;
    }
}
