import { Plugins} from '@capacitor/core';
const { FaceId } = Plugins;


export default new function faceAuth(){
FaceId.isAvailable().then(checkResult => {
    if(checkResult.value) {
        FaceId.auth().then(() => {
            alert("auth!")
        }).catch((error) => {
            // handle rejection errors
            console.error(error.message);
        });
    } else {
        // use custom fallback authentication here
    }
})};