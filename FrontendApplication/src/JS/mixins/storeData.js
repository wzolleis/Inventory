import APIRequests from "@/JS/API/APIRequests";
import {storeDefinition} from '/src/JS/Models/ProductObject'
import DataModel from "@/store/modules/models/DataModel";
import store from "@/store";

export default {

    methods: {
        async storeData(type, id) {
            this.registerStoreModule(storeDefinition[type].storePath(id), DataModel)
            await APIRequests.getURL(storeDefinition[type].apiURL(id))
            await APIRequests.setStore(storeDefinition[type].mutation(id))
        },


        getData(type, id) {
            console.log("Data returned by getData: ", storeDefinition[type].getter(id));
            return storeDefinition[type].getter(id)
        },

        setData(type, id, payload) {
            const storedef = storeDefinition[type];
            store.commit(storedef.mutation(id), payload)
            console.log(storedef.getter(id));
            APIRequests.setData(storedef.apiURL(id), payload).then(r => console.log(r))

        },
        deleteData(type, id){
            APIRequests.deleteRequest(storeDefinition[type].apiURL(id)).then(r => console.log(r))
        },
        registerStoreModule(moduleName, storeModule) {
            const store = this.$store;

            if (!(store && store.state && store.state[moduleName])) {
                store.registerModule(moduleName, storeModule);
            }
        },

    }


}