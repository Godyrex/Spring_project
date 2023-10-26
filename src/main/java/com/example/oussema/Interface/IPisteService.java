package com.example.oussema.Interface;

import com.example.oussema.entity.Piste;

import java.util.List;

public interface IPisteService {
    Piste savePiste(Piste piste);
    Piste getPisteById(Long id);
    List<Piste> getAllPistes();
    void deletePiste(Long id);
}
