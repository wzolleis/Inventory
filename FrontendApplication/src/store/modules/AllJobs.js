
const state = {
    jobs: null
};

const getters = {
    getAllJobs(state){
        return state.jobs
    },
    getJobById: (state) => (id) => {
        return state.jobs.find(job => job.id === id)
}
};

const actions = {};

const mutations = {
    SET_JOBS(state, payload) {
        state.jobs = payload;
    },
};

export default {
    state,
    getters,
    actions,
    mutations,
};