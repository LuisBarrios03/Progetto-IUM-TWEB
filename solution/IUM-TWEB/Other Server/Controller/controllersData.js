const modelRottenTomatoes =require('../Model/rottenTomatoesReviews')
const modelTheOscarAwards =require('../Model/theOscarAwards')


exports.getAllDataRottenTomatoes = async (req,res) => {
    try{
        const CollectionRottenTomatoes = await modelRottenTomatoes.find().limit(100);
        //console.log(CollectionRottenTomatoes);
        //const CollectionTheOscarAwards = await  modelTheOscarAwards.find().limit(100);
        //console.log(CollectionTheOscarAwards);
        res.json({
            success: true,
            data:{
                rottenTomatoesReviews : CollectionRottenTomatoes,
                //theOscarAwards : CollectionTheOscarAwards,

            },
        });
    }catch (error){
        res.status(500).json({
            success: false,
            message: 'not found',
            error:error.message,
        });
    }
}
exports.getAllDataTheOscarAwards = async (req,res) => {
    try{
        const CollectionTheOscarAwards = await  modelTheOscarAwards.find().limit(100);
        res.json({
            success: true,
            data:{
                theOscarAwards : CollectionTheOscarAwards,
            },
        });
    }catch (error){
        res.status(500).json({
            success: false,
            message: 'not found',
            error:error.message,
        });
    }
}


exports.get20OscarAwards = async (req, res) => {
    try {
        let page = parseInt(req.query.page) || 0; // Pagina corrente (di default 0)
        let size = parseInt(req.query.size) || 2; // Numero di elementi per pagina (default 20)

        const oscars = await modelTheOscarAwards
            .find()
            .sort({ year: -1 }) // Ordina dal più recente al più vecchio
            .skip(page * size) // Salta le pagine precedenti
            .limit(size); // Limita il numero di risultati

        if (oscars.length === 0) {
            return res.status(404).json({ success: false, message: "Nessun Oscar trovato" });
        }
        res.json({
            success: true,
            data: oscars,
        });
    } catch (error) {
        res.status(500).json({
            success: false,
            message: "Errore nel recupero dei dati degli Oscar",
            error: error.message,
        });
    }
};
