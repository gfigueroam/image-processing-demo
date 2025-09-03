/**
 * Send request to filter the image on click with the filter selected
 */
function filterImage(){
	var filterId = document.getElementById("filterId").value;
	var originalImage = encodeURIComponent(document.getElementById("originalImage").src);
	document.getElementById("filteredImage").src = "filtered_images/fruits.png?filterId="+filterId+"&originalImage="+originalImage;

}