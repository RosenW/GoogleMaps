package map.entities;

import javax.persistence.*;

@Table(name = "markers")
@Entity
public class Marker {
    @Id
    private String id;
    private double lat;
    private double lng;

    public Marker() {
    }

    public Marker(String id, String lat, String lng) {
        this.setId(id);
        this.setLat(Double.parseDouble(lat));
        this.setLng(Double.parseDouble(lng));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    private void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    private void setLng(double lng) {
        this.lng = lng;
    }
}