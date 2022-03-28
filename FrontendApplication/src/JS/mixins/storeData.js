import APIRequests from "@/JS/API/APIRequests";
import {storeDefinition} from '/src/JS/Models/ProductObject'
import DataModel from "@/store/modules/models/DataModel";

export default {

    methods: {

        async storeData(type, id) {
            this.registerStoreModule(storeDefinition[type].storePath(id), DataModel)
            await APIRequests.getURL(storeDefinition[type].apiURL(id))
            await APIRequests.setStore(storeDefinition[type].mutation(id))
        },
        getData(type, id){
            console.log("Data returned by getData: ", storeDefinition[type].getter(id));
            return storeDefinition[type].getter(id)
        },
        registerStoreModule(moduleName, storeModule) {
            const store = this.$store;

            if (!(store && store.state && store.state[moduleName])) {
                store.registerModule(moduleName, storeModule);
            }
        },

    }


}