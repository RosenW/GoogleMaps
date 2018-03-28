package map.controllers;

import map.entities.Marker;
import map.models.Place;
import map.services.MarkerService;
import map.utils.GoogleMapsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final MarkerService markerService;

    @Autowired
    public HomeController(MarkerService markerService) {
        this.markerService = markerService;
    }

    private void findAndSaveLocationsToDB(int latFrom, int lngFrom, int latTo, int lngTo, int latIncrement, int lngIncrement) {
        GoogleMapsUtils googleMapsUtils = new GoogleMapsUtils();
        for (int lat = latFrom; lat < latTo; lat+=latIncrement) {
            for (int lng = lngFrom; lng < lngTo; lng+=lngIncrement) {
                List<Place> places = googleMapsUtils.search("", lat,lng, 50000);
                List<Marker> markers = new ArrayList<>();
                for (Place place : places) {
                    markers.add(new Marker(place.getId(), place.getLat(), place.getLng()));
                }
                markerService.saveAll(markers);
            }
        }

    }

    @GetMapping("/")
    public String getHomePage(Model model) {

        return "home";
    }

    @GetMapping("/markers")
    @ResponseBody
    public List<Marker> getMarkers() {
        return markerService.getAllMarkers();
    }
}