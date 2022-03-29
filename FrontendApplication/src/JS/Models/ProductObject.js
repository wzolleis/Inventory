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
        ...buildMethods("product")
    },
    job: {
        ...buildMethods("job")
    },
    jobid: {
        ...buildMethods("jobid")

    },
    workshop: {
        ...buildMethods("workshop")

    },
    installation: {
        ...buildMethods("installation")

    },
    category: {
        ...buildMethods("category")
    },
    position: {
        ...buildMethods("position")
    }


}