module.exports = (io) => {
    io.on("connection", (socket) => {
        console.log("Un utente si è connesso");

        socket.on("chat message", (data) => {
            console.log(`Messaggio ricevuto: ${data.message} da ${data.username}`);
            io.emit("chat message", data); // Invia il messaggio a tutti i client
        });

        socket.on("disconnect", () => {
            console.log("Un utente si è disconnesso");
        });
    });
};
