package map.services;

import map.entities.Marker;

import java.util.List;

public interface MarkerService {
    List<Marker> getAllMarkers();

    void saveAll(List<Marker> markers);
}
