package com.doctors.model.DTOs;

import com.doctors.model.ClientModel;

public class CountClient {
    private Long total;
    private ClientModel clientModel;

    public CountClient(Long total, ClientModel clientModel) {
        this.total = total;
        this.clientModel = clientModel;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }
}
