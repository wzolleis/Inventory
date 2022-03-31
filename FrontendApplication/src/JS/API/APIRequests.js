import axios from "axios"
import store from "@/store";


export default new (class APIRequests {

    async getURL(url) {
         return await axios.get("http://localhost:8080/api/" + url).then((response) => {
             store.commit("SET_RESPONSE", response.data)
         })
            .catch((error) => {
                console.log(error);
            })
    }

    async setData(url, data){
        console.log("Data:", data);
        await axios({
           method: "post",
           url: "http://localhost:8080/api/" + url ,
           data: data
       })

    }

    async deleteRequest(url){
        await axios({
            method: "delete",
            url: "http://localhost:8080/api/" + url,
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