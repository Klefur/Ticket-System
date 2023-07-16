import httpCommon from "../http-common";

class Ticket {
    getAll() {
        return httpCommon.get("/ticket");
    }

    get(id) {
        return httpCommon.get(`/ticket/${id}`);
    }

    getRut(rut) {
        return httpCommon.get(`/ticket/rut/${rut}`);
    }

    create(data) {
        return httpCommon.post("/ticket", data);
    }

    update(id, data) {
        return httpCommon.put(`/ticket/${id}`, data);
    }

    delete(id) {
        return httpCommon.delete(`/ticket/${id}`);
    }
}

export default new Ticket();