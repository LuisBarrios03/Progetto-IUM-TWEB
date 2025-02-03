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


//@returns the most recent 100 Oscar Awards
exports.get100OscarAwards = async (req, res) => {
    try {
        const oscars = await modelTheOscarAwards
            .find()
            .sort({ year_ceremony: -1 }) // Ordina per cerimonia, dalla più recente alla più vecchia
            .limit(100); // Limita il numero di risultati

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



//@returns oscasr found by search
exports.getOscars = async (req, res) => {
    try {
        const { film } = req.query;
        const oscars = await modelTheOscarAwards
            .find({ film: new RegExp(film, 'i') }) // Filtra per nome del film, ignorando maiuscole/minuscole
            .sort({ year_ceremony: -1 }) // Ordina per cerimonia, dalla più recente alla più vecchia
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
