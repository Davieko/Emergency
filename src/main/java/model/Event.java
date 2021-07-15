package model;

import java.time.LocalTime;


//la coda dev'essere inserita in una coda prioritaria quindi deve implementare
//l'interfaccia comparable su eventi
public class Event implements Comparable<Event>{
	
	enum EventType{
		ARRIVAL, //arriva paziente nuovo , entra nel triage
		TRIAGE, //finito il triage, entro in sala 'attesa
		TIMEOUT, //passa un certo tempo di attesa
		FREE_STUDIO, //si è liverato uno studio, chiamiamo qualcuno
		TREATED, //paziente curato
		TICK, //timer per controllare se ci sono studi liberi
	};
	
	private LocalTime time;
	private EventType type;
	private Patient patient;
	public Event(LocalTime time, EventType type, Patient patient) {
		super();
		this.time = time;
		this.type = type;
		this.patient = patient;
	}
	public LocalTime getTime() {
		return time;
	}
	public EventType getType() {
		return type;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public int compareTo(Event other) {	
		//deve confrontare la marcatur temporale
		return this.time.compareTo(other.time);
	}
	@Override
	public String toString() {
		return "Event [time=" + time + ", type=" + type + ", patient=" + patient + "]";
	}
	
	
	
}
