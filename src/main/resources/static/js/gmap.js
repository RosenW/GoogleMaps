let bulgariaCoords = {lat: 42.7, lng: 25.4};
let map;

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: bulgariaCoords,
        zoom: 6
    });

    $.get("/markers").done(function (data) {
                  let markers = data;

                  markers.forEach((element) => {
                          let curMarker = new google.maps.Marker({
                              position: {lat: element.lat,lng: element.lng},
                              map: map
                          });
                      });
             });

//    let script = document.createElement('script');
//    document.getElementsByTagName('head')[0].appendChild(script);
//    console.log(script);
//    script.src = 'https://developers.google.com/maps/documentation/javascript/examples/json/earthquake_GeoJSONP.js';
}

//window.eqfeed_callback = function(results) {
//    for (let i = 0; i < results.features.length; i++) {
//        let coords = results.features[i].geometry.coordinates;
//        let curMarker = new google.maps.Marker({
//            position: {lat: coords[1], lng: coords[0]},
//            map: map
//        });
//    }
//}
