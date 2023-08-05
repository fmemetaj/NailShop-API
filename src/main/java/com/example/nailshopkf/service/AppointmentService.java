package com.example.nailshopkf.service;

import com.example.nailshopkf.entity.Appointment;
import com.example.nailshopkf.exceptions.AppointmentNotFoundException;
import com.example.nailshopkf.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(AppointmentNotFoundException::new);
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {
        return appointmentRepository.findById(id)
                .map(existingNailService -> {
                    appointment.setId(id);
                    return appointmentRepository.save(appointment);
                })
                .orElseThrow(AppointmentNotFoundException::new);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.findById(id)
                .orElseThrow(AppointmentNotFoundException::new);
        appointmentRepository.deleteById(id);
    }
}
