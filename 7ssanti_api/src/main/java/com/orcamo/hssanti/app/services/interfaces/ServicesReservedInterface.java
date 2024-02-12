package com.orcamo.hssanti.app.services.interfaces;

public interface ServicesReservedInterface {
    public void addServicetoReservation(Integer articleId,Integer clientId);
    public void removeServiceFromReservation(Integer articleId,Integer clientId);
}
