import axios from "axios"
import store from "@/store";


export default new (class APIRequests {

    async getURL(url) {
         return await axios.get("http://localhost:8080/api/" + url).then((response) => {
             console.log(response.data);
             store.commit("SET_RESPONSE", response.data)
         })
            .catch((error) => {
                console.log(error);
            })
    }

    async setStore(commit)
    {
        new Promise(resolve => {
            store.commit(commit, store.getters.getResponseData);
            resolve("Done")
        });
    }

})