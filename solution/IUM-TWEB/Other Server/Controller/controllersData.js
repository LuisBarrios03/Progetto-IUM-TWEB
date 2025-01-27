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
        //const CollectionRottenTomatoes = await modelRottenTomatoes.find().limit(100);
        //console.log(CollectionRottenTomatoes);
        const CollectionTheOscarAwards = await  modelTheOscarAwards.find().limit(100);
        //console.log(CollectionTheOscarAwards);
        res.json({
            success: true,
            data:{
                //rottenTomatoesReviews : CollectionRottenTomatoes,
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