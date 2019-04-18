const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

let img = new Image();
let originalImg = new Image();
let fileName = "";
let letters = document.getElementById("letters");

const uploadFile = document.getElementById("upload-file");
const processBtn = document.getElementById("process-btn");
const downloadBtn = document.getElementById("download-btn");
const revertBtn = document.getElementById("revert-btn");



function processImage(){
		
	var dataURL = canvas.toDataURL('image/jpeg', 1);
	var blob = dataURItoBlob(dataURL);
	var formData = new FormData(document.forms[0]);
	formData.append("file", blob);
	
	function dataURItoBlob(dataURI) {
	    // convert base64/URLEncoded data component to raw binary data held in a string
	    var byteString;
	    if (dataURI.split(',')[0].indexOf('base64') >= 0)
	        byteString = atob(dataURI.split(',')[1]);
	    else
	        byteString = unescape(dataURI.split(',')[1]);

	    // separate out the mime component
	    var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];

	    // write the bytes of the string to a typed array
	    var ia = new Uint8Array(byteString.length);
	    for (var i = 0; i < byteString.length; i++) {
	        ia[i] = byteString.charCodeAt(i);
	    }

	    return new Blob([ia], {type:mimeString});
	}

	var xhttp1 = new XMLHttpRequest();
	var xhttp2 = new XMLHttpRequest();
	
	xhttp1.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	img.src = "data:image/jpg;base64, "+ xhttp1.responseText;
	    	document.getElementById("letters").innerHTML = xhttp1.responseText;
	    }
	};
	xhttp2.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	document.getElementById("letters").innerHTML = xhttp2.responseText;
	    }
	};

	xhttp1.open("post", "Image", false);	

	xhttp1.send(formData);
	
	xhttp2.open("get", "Image", false);	

	xhttp2.send();
}



// Upload File
uploadFile.addEventListener("change", () => {
  // Get File
  const file = document.getElementById("upload-file").files[0];
  // Init FileReader API
  const reader = new FileReader();

  // Check for file
  if (file) {
    // Set file name
    fileName = file.name;
    // Read data as URL
    reader.readAsDataURL(file);
  }

  // Add image to canvas
  reader.addEventListener(
    "load",
    () => {
      // Create image
      img = new Image();
      // Set image src
      img.src = reader.result;
      originalImg.src = reader.result;
      // On image load add to canvas
      img.onload = function() {
        canvas.width = img.width;
        canvas.height = img.height;
        ctx.drawImage(img, 0, 0, img.width, img.height);
        canvas.removeAttribute("data-caman-id");
      };
    },
    false
  );
});


// Download Event
downloadBtn.addEventListener("click", () => {
  // Get ext
  const fileExtension = fileName.slice(-4);

  // Init new filename
  let newFilename;

  // Check image type
  if (fileExtension === ".jpg" || fileExtension === ".png") {
    // new filename
    newFilename = fileName.substring(0, fileName.length - 4) + "-edited.jpg";
  }

  // Call download
  download(canvas, newFilename);
});

// Download
function download(canvas, filename) {
  // Init event
  let e;
  // Create link
  const link = document.createElement("a");

  // Set props
  link.download = filename;
  link.href = canvas.toDataURL("image/jpeg", 1);
  // New mouse event
  e = new MouseEvent("click");
  // Dispatch event
  link.dispatchEvent(e);
}


// Revert Filters
revertBtn.addEventListener("click", e => {
	img.src = originalImg.src;
});


