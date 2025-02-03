async function searchOscars() {
    try {
        let title = document.getElementById("searchTitle").value;
        let response = await fetch(`http://localhost:3001/api/findOscar?film=${encodeURIComponent(title)}`);
        let data = await response.json();
        if (data.success) {
            console.log("Oscars found:", data.data);
        } else {
            console.error("No Oscars found:", data.message);
        }
        window.location.href = `/oscarsSearched?film=${encodeURIComponent(title)}`;
    } catch (error) {
        console.error("Errore nella ricerca degli Oscar:", error);
    }
}

