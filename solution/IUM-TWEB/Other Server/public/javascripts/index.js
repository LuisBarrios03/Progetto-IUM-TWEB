function init(){
    fetch('/api/data')
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                document.getElementById('data').innerText = JSON.stringify(data.data, null, 2);
            } else {
                document.getElementById('data').innerText = 'Errore nel recupero dei dati';
            }
        })
        .catch(err => console.error('Errore:', err));
}