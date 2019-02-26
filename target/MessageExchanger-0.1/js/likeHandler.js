function addLike(buttonId){
    var likeButton = document.getElementById(buttonId);
    var counter = parseInt(likeButton.innerText);
    likeButton.innerText = counter+1;
}
