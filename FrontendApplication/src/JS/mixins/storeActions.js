import APIRequests from "@/JS/API/APIRequests";
import SingleProductData from "@/store/modules/models/SingleProductData";
import AllProducts from "@/store/modules/models/AllProducts";
import SingleJobData from "@/store/modules/models/SingleJobData";
import DynamicStore from "@/store/modules/models/DynamicStore";


export default {
    methods: {
        async storeProduct(productID) {
            const storePath = this.constructStorePath("productid", productID)
            this.registerStoreModule(storePath, SingleProductData)
            await APIRequests.getURL("inventory/id/" + productID)
            await APIRequests.setStore(this.constructMutationPath(storePath, "SET_PRODUCT"))

        },
        async storeAllProducts(param) {
            const storePath = this.constructStorePath("products", param)
            this.registerStoreModule(storePath, AllProducts)
            await APIRequests.getURL("inventory/id/" + param)
            await APIRequests.setStore(this.constructMutationPath(storePath, "SET_PRODUCTS"))

        },
        async storeJobWithPID(productID) {
            const storePath = this.constructStorePath("jobpid", productID)
            this.registerStoreModule(storePath, SingleJobData)
            await APIRequests.getURL("jobs/productid/" + productID)
            await APIRequests.setStore(this.constructMutationPath(storePath, "SET_JOB"))

        },
        async storeJob(jobID) {
            const storePath = this.constructStorePath("jobid", jobID)
            this.registerStoreModule(storePath, SingleJobData)
            await APIRequests.getURL("jobs/id/" + jobID)
            await APIRequests.setStore(this.constructMutationPath(storePath, "SET_JOB"))


        },
        async storeJobProducts(jobID) {
            const storePath = this.constructStorePath("jobproducts", jobID)
            this.registerStoreModule(storePath, SingleJobData)
            await APIRequests.getURL("jobs/products/" + jobID)
            await APIRequests.setStore(this.constructMutationPath(storePath, "SET_JOB"))

        },
        async storeAllJobs() {
            const storePath = this.constructStorePath("jobid", "all")
            this.registerStoreModule(storePath, SingleJobData)
            await APIRequests.getURL("jobs/" + "all")
            await APIRequests.setStore(this.constructMutationPath(storePath, "SET_JOB"))

        },
        getSingleProduct(productID, information) {
            const storePath = this.constructStorePath("productid", productID)
            if (information === undefined) {
                console.log("undefined");
                return this.$store.getters[storePath + "/getProductData"]
            } else {
                return this.$store.getters[storePath + "/getProductData"][information]

            }
        },
        getSingleJob(jobID, information) {
            const storePath = this.constructStorePath("jobid", jobID)
            return this.$store.getters[storePath + "/getJobData"][information]
        },
        getJobArray(jobID) {
            const storePath = this.constructStorePath("jobid", jobID)
            return this.$store.getters[storePath + "/getJobData"]
        },
        getAllJobs(param) {
            if(param === undefined){
                param = "all"
            }
            const storePath = this.constructStorePath("jobid", param);
            return this.$store.getters[storePath + "/getJobData"]
        },
        getJobProducts(jobID) {
            const storePath = this.constructStorePath("jobproducts", jobID);
            return this.$store.getters[storePath + "/getJobData"]
        },
        getSingleJobWithPID(productID, information) {
            const storePath = this.constructStorePath("jobpid", productID)
            console.log("Requested Data", this.$store.getters[storePath + "/getJobData"][information]);
            return this.$store.getters[storePath + "/getJobData"][information]
        },
        async storeOptions(option) {
            const storePath = this.constructStorePath("option", option)
            this.registerStoreModule(storePath, DynamicStore)
            await APIRequests.getURL("inventory/" + option)
            await APIRequests.setStore(this.constructMutationPath(storePath, "SET_DATA"))

        },
        getOptions(option) {
            const storePath = this.constructStorePath("option", option)
            return this.$store.getters[storePath + "/getData"]
        },


        constructStorePath(type, productID) {
            return type + productID
        },
        constructMutationPath(storePath, mutation) {
            return storePath + "/" + mutation
        },
        registerStoreModule(moduleName, storeModule) {
            const store = this.$store;

            if (!(store && store.state && store.state[moduleName])) {
                store.registerModule(moduleName, storeModule);
            }
        },


    }


}