/*
 * @Author: Jipu Li 
 * @Date: 2022-03-26 19:02:53 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-03-26 19:33:31
 */

// Initialize and add the map
function initMap() {
  // The location of Uluru
  const uluru = { lat: 53.383, lng: -1.466 };
  // The map, centered at Uluru
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 6,
    center: uluru,
  });
  // The marker, positioned at Uluru
  const marker = new google.maps.Marker({
    position: uluru,
    map: map,
  });
}