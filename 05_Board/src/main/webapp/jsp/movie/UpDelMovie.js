function delMovie(id) {
    let ok = confirm("really?");
    if(ok){
        location.href="delUpMovie?id="+id+"&type=d";
    }
}
function updateMovie(id, movie) {
    let edit = prompt("really?",movie);
    if(edit!=null && edit != ""){
        location.href="delUpMovie?id="+id+"&edit="+edit;
    }
}