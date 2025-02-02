module.exports = (io) => {
    io.on('connection', (socket) => {
        console.log('A user connected');
        // insert other events socket.on(message)

// disconnection event
        socket.on('disconnect', () => {
            console.log('A user disconnected');
        });
    });
};