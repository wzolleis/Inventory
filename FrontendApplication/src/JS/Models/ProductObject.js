import DataContent from "@/JS/Models/DataContent";

export const buildMethods = (type) => {
    return {
        storePath: (id) => new DataContent().buildStorePath(type, id),
        apiURL: (id) => new DataContent().buildApiURL(type, id),
        getter: (id) => new DataContent().buildGetter(type, id),
        mutation: (id) => new DataContent().buildMutation(type, id)
    }
}


export const storeDefinition = {

    product: {
        // storePath: (id) => new DataContent().buildStorePath(storeDefinition.product.type, id),
        // apiURL: (id) => new DataContent().buildApiURL(storeDefinition.product.type, id),
        // getter: (id) => new DataContent().buildGetter(storeDefinition.product.type, id),
        // mutation: (id) => new DataContent().buildMutation(storeDefinition.product.type, id)
        ...buildMethods("product")
    },
    job: {
        ...buildMethods("job")
    },
    jobid: {
        type: "jobid",
        storePath: (id) => new DataContent().buildStorePath(storeDefinition.jobid.type, id),
        apiURL: (id) => new DataContent().buildApiURL(storeDefinition.jobid.type, id),
        getter: (id) => new DataContent().buildGetter(storeDefinition.jobid.type, id),
        mutation: (id) => new DataContent().buildMutation(storeDefinition.jobid.type, id)

    },
    workshop: {
        type: "workshop",
        storePath: (id) => new DataContent().buildStorePath(storeDefinition.workshop.type, id),
        apiURL: (id) => new DataContent().buildApiURL(storeDefinition.workshop.type, id),
        getter: (id) => new DataContent().buildGetter(storeDefinition.workshop.type, id),
        mutation: (id) => new DataContent().buildMutation(storeDefinition.workshop.type, id)

    },
    installation: {
        type: "installation",
        storePath: (id) => new DataContent().buildStorePath(storeDefinition.installation.type, id),
        apiURL: (id) => new DataContent().buildApiURL(storeDefinition.installation.type, id),
        getter: (id) => new DataContent().buildGetter(storeDefinition.installation.type, id),
        mutation: (id) => new DataContent().buildMutation(storeDefinition.installation.type, id)

    }


}