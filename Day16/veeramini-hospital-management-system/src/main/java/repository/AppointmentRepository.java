package repository;

import model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends MongoRepository<Appointment,String> {

    public Appointment findBydoctorName(String doctorName);

    public Appointment findBypatientName(String patientName);

    public Appointment save(Appointment appointment);
}
