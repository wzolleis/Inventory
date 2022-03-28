import store from "@/store";


export default class DataContent {
    buildStorePath(type, id) {
        return type + id
    }

    buildApiURL(type, id) {
        return type + "/" + id
    }

    buildGetter(type, id) {
        return store.getters[this.buildStorePath(type, id) + "/getStoreData"]
    }

    buildMutation(type, id) {
        return this.buildStorePath(type, id) + "/" + "SET_DATA"
    }

}