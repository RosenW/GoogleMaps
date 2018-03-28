package map.services;

import map.entities.Marker;
import map.repository.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerServiceImpl implements MarkerService {
    private final MarkerRepository markerRepository;

    @Autowired
    public MarkerServiceImpl(MarkerRepository markerRepository) {
        this.markerRepository = markerRepository;
    }

    @Override
    public List<Marker> getAllMarkers() {
        return markerRepository.findAll();
    }

    @Override
    public void saveAll(List<Marker> markers) {
        markerRepository.saveAll(markers);
    }
}
