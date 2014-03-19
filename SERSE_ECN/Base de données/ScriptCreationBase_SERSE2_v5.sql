-- BASE DONNEES serse : création de la base
-- Auteurs : Clara Doucoure et Audrey Pouchoulin
-- Date création : 30/01/2014
-- Date dernière modification : 15/04/2014
-- Version : 5

CREATE SEQUENCE serse.continent_continent_id_seq;

CREATE TABLE serse.continent (
                continent_id INTEGER NOT NULL DEFAULT nextval('serse.continent_continent_id_seq'),
                continent_nom VARCHAR(50) NOT NULL,
                CONSTRAINT continent_id_pk PRIMARY KEY (continent_id)
);


ALTER SEQUENCE serse.continent_continent_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.entreprise_entreprise_id_seq;

CREATE TABLE serse.entreprise (
                entreprise_id INTEGER NOT NULL DEFAULT nextval('serse.entreprise_entreprise_id_seq'),
                entreprise_nom VARCHAR(50) NOT NULL,
                CONSTRAINT entreprise_id_pk PRIMARY KEY (entreprise_id)
);


ALTER SEQUENCE serse.entreprise_entreprise_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.domaineactivite_domaineactivite_id_seq;

CREATE TABLE serse.domaineActivite (
                domaineActivite_id INTEGER NOT NULL DEFAULT nextval('serse.domaineactivite_domaineactivite_id_seq'),
                domaineActivite_libelle VARCHAR(100) NOT NULL,
                CONSTRAINT domaineactivite_id_pk PRIMARY KEY (domaineActivite_id)
);


ALTER SEQUENCE serse.domaineactivite_domaineactivite_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.typeexperience_typeexperience_id_seq;

CREATE TABLE serse.typeExperience (
                typeExperience_id INTEGER NOT NULL DEFAULT nextval('serse.typeexperience_typeexperience_id_seq'),
                typeExperience_libelle VARCHAR(50) NOT NULL,
                CONSTRAINT typeexperience_id_pk PRIMARY KEY (typeExperience_id)
);


ALTER SEQUENCE serse.typeexperience_typeexperience_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.typesejour_typesejour_id_seq;

CREATE TABLE serse.typeSejour (
                typeSejour_id INTEGER NOT NULL DEFAULT nextval('serse.typesejour_typesejour_id_seq'),
                typeSejour_libelle VARCHAR(50) NOT NULL,
                CONSTRAINT typesejour_id_pk PRIMARY KEY (typeSejour_id)
);


ALTER SEQUENCE serse.typesejour_typesejour_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.typemobilite_typemobilite_id_seq;

CREATE TABLE serse.typeMobilite (
                typeMobilite_id INTEGER NOT NULL DEFAULT nextval('serse.typemobilite_typemobilite_id_seq'),
                typeMobilite_libelle VARCHAR(50) NOT NULL,
                CONSTRAINT typemobilite_pk PRIMARY KEY (typeMobilite_id)
);


ALTER SEQUENCE serse.typemobilite_typemobilite_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.pays_pays_id_seq;

CREATE TABLE serse.pays (
                pays_id INTEGER NOT NULL DEFAULT nextval('serse.pays_pays_id_seq'),
                pays_nom VARCHAR(50) NOT NULL,
                continent_id INTEGER NOT NULL,
                CONSTRAINT pays_id_pk PRIMARY KEY (pays_id)
);


ALTER SEQUENCE serse.pays_pays_id_seq OWNER TO "serse-ecn";

CREATE TABLE serse.entreprise_pays (
                entreprise_id INTEGER NOT NULL,
                pays_id INTEGER NOT NULL,
                CONSTRAINT entreprise_pays_id_pk PRIMARY KEY (entreprise_id, pays_id)
);


CREATE SEQUENCE serse.ville_ville_id_seq;

CREATE TABLE serse.ville (
                ville_id INTEGER NOT NULL DEFAULT nextval('serse.ville_ville_id_seq'),
                ville_nom VARCHAR(50) NOT NULL,
                pays_id INTEGER NOT NULL,
                CONSTRAINT ville_id_pk PRIMARY KEY (ville_id)
);


ALTER SEQUENCE serse.ville_ville_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.universite_universite_id_seq;

CREATE TABLE serse.universite (
                universite_id INTEGER NOT NULL DEFAULT nextval('serse.universite_universite_id_seq'),
                universite_nom VARCHAR(100) NOT NULL,
                ville_id INTEGER NOT NULL,
                CONSTRAINT universite_id_pk PRIMARY KEY (universite_id)
);


ALTER SEQUENCE serse.universite_universite_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.lieusejour_lieusejour_id_seq;

CREATE TABLE serse.lieuSejour (
                lieuSejour_id INTEGER NOT NULL DEFAULT nextval('serse.lieusejour_lieusejour_id_seq'),
                lieuSejour_adresse VARCHAR(100) NOT NULL,
                lieuSejour_codePostal VARCHAR(10) NOT NULL,
                ville_id INTEGER NOT NULL,
                lieuSejour_GPSlatitude VARCHAR(50) NOT NULL,
                lieuSejour_GPSlongitude VARCHAR(50) NOT NULL,
                CONSTRAINT lieusejour_id_pk PRIMARY KEY (lieuSejour_id)
);


ALTER SEQUENCE serse.lieusejour_lieusejour_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.etat_etat_id_seq;

CREATE TABLE serse.etat (
                etat_id INTEGER NOT NULL DEFAULT nextval('serse.etat_etat_id_seq'),
                etat_libelle VARCHAR NOT NULL,
                CONSTRAINT etat_id_pk PRIMARY KEY (etat_id)
);


ALTER SEQUENCE serse.etat_etat_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.langue_langue_id_seq;

CREATE TABLE serse.langue (
                langue_id INTEGER NOT NULL DEFAULT nextval('serse.langue_langue_id_seq'),
                langue_nom VARCHAR(50) NOT NULL,
                CONSTRAINT langue_id_pk PRIMARY KEY (langue_id)
);


ALTER SEQUENCE serse.langue_langue_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.utilisateur_utilisateur_id_seq;

CREATE TABLE serse.utilisateur (
                utilisateur_id INTEGER NOT NULL DEFAULT nextval('serse.utilisateur_utilisateur_id_seq'),
                utilisateur_nom VARCHAR(50) NOT NULL,
                utilisateur_prenom VARCHAR(50) NOT NULL,
                utilisateur_sexe VARCHAR(1) DEFAULT 'N' NOT NULL,
                utilisateur_email VARCHAR(200) NOT NULL,
                utilisateur_token VARCHAR UNIQUE,
                utilisateur_token_expire TIMESTAMP,
				utilisateur_active BOOLEAN NOT NULL DEFAULT TRUE,
                CONSTRAINT utilisateur_id_pk PRIMARY KEY (utilisateur_id)
);

ALTER SEQUENCE serse.utilisateur_utilisateur_id_seq OWNER TO "serse-ecn";

COMMENT ON COLUMN serse.utilisateur.utilisateur_sexe IS 'Possibles Values : F ou M ou N';


CREATE SEQUENCE serse.administrateur_administrateur_id_seq;

CREATE TABLE serse.administrateur (
                administrateur_id INTEGER NOT NULL DEFAULT nextval('serse.administrateur_administrateur_id_seq'),
                administrateur_notification BOOLEAN DEFAULT TRUE NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                CONSTRAINT administrateur_id_pk PRIMARY KEY (administrateur_id)
);


ALTER SEQUENCE serse.administrateur_administrateur_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.session_session_id_seq;

CREATE TABLE serse.sessionutilisateur (
                session_id INTEGER NOT NULL DEFAULT nextval('serse.session_session_id_seq'),
                session_adresseIP INTEGER NOT NULL,
                session_dateHeureDebut TIMESTAMP NOT NULL,
                session_dateHeureFin TIMESTAMP NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                CONSTRAINT session_id_pk PRIMARY KEY (session_id)
);


ALTER SEQUENCE serse.session_session_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.dri_dri_id_seq;

CREATE TABLE serse.dri (
                dri_id INTEGER NOT NULL DEFAULT nextval('serse.dri_dri_id_seq'),
                dri_notification_assignation BOOLEAN DEFAULT TRUE NOT NULL,
                dri_notification_soumission BOOLEAN DEFAULT TRUE NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                CONSTRAINT dri_id_pk PRIMARY KEY (dri_id)
);
COMMENT ON COLUMN serse.dri.dri_notification_assignation IS 'Par défaut, l''utilisateur reçoit les notifications de soumissions';
COMMENT ON COLUMN serse.dri.dri_notification_soumission IS 'Idem : par défaut, envoi de notifications';


ALTER SEQUENCE serse.dri_dri_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.rapport_rapport_id_seq;

CREATE TABLE serse.rapport (
                rapport_id INTEGER NOT NULL DEFAULT nextval('serse.rapport_rapport_id_seq'),
                rapport_nom VARCHAR(100) NOT NULL,
                rapport_dateDebut DATE NOT NULL,
                rapport_dateFin DATE NOT NULL,
                rapport_numeroVersion INTEGER NOT NULL,
                rapport_tailleFichier VARCHAR NOT NULL,
                typeMobilite_id INTEGER NOT NULL,
                typeSejour_id INTEGER NOT NULL,
                typeExperience_id INTEGER NOT NULL,
                lieuSejour_id INTEGER NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                dri_id INTEGER NOT NULL,
                universite_id INTEGER,
                entreprise_id INTEGER,
                domaineActivite_id INTEGER NOT NULL,
                CONSTRAINT rapport_id_pk PRIMARY KEY (rapport_id)
);


ALTER SEQUENCE serse.rapport_rapport_id_seq OWNER TO "serse-ecn";

CREATE TABLE serse.rapport_etat (
                etat_id INTEGER NOT NULL,
                dri_id INTEGER NOT NULL,
                rapport_id INTEGER NOT NULL,
                rapport_etat_dateHeure TIMESTAMP NOT NULL,
                CONSTRAINT rapport_etat_id_pk PRIMARY KEY (etat_id, dri_id, rapport_id)
);


CREATE SEQUENCE serse.fichier_fichier_id_seq;

CREATE TABLE serse.fichier (
                fichier_id INTEGER NOT NULL DEFAULT nextval('serse.fichier_fichier_id_seq'),
                fichier_nom VARCHAR(50) NOT NULL,
                fichier_taille REAL NOT NULL,
                fichier_dateHeure TIMESTAMP NOT NULL,
                fichier_version INTEGER NOT NULL,
                rapport_id INTEGER NOT NULL,
                CONSTRAINT fichier_id_pk PRIMARY KEY (fichier_id)
);


ALTER SEQUENCE serse.fichier_fichier_id_seq OWNER TO "serse-ecn";

CREATE SEQUENCE serse.commentaire_commentaire_id_seq;

CREATE TABLE serse.commentaire (
                commentaire_id INTEGER NOT NULL DEFAULT nextval('serse.commentaire_commentaire_id_seq'),
                commentaire_dateHeure TIMESTAMP NOT NULL,
                commentaire_contenu VARCHAR(500) NOT NULL,
                dri_id INTEGER NOT NULL,
                fichier_id INTEGER NOT NULL,
                CONSTRAINT commentaire_id_pk PRIMARY KEY (commentaire_id)
);


ALTER SEQUENCE serse.commentaire_commentaire_id_seq OWNER TO "serse-ecn";

CREATE TABLE serse.rapport_langue (
                rapport_id INTEGER NOT NULL,
                langue_id INTEGER NOT NULL,
                CONSTRAINT rapport_langue_id_pk PRIMARY KEY (rapport_id, langue_id)
);


ALTER TABLE serse.pays ADD CONSTRAINT continent_pays_fk
FOREIGN KEY (continent_id)
REFERENCES serse.continent (continent_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.entreprise_pays ADD CONSTRAINT entreprise_entreprise_pays_fk
FOREIGN KEY (entreprise_id)
REFERENCES serse.entreprise (entreprise_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport ADD CONSTRAINT entreprise_rapport_fk
FOREIGN KEY (entreprise_id)
REFERENCES serse.entreprise (entreprise_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport ADD CONSTRAINT domaineactivite_rapport_fk
FOREIGN KEY (domaineActivite_id)
REFERENCES serse.domaineActivite (domaineActivite_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport ADD CONSTRAINT typeexperience_rapport_fk
FOREIGN KEY (typeExperience_id)
REFERENCES serse.typeExperience (typeExperience_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport ADD CONSTRAINT typesejour_rapport_fk
FOREIGN KEY (typeSejour_id)
REFERENCES serse.typeSejour (typeSejour_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport ADD CONSTRAINT typemobilite_rapport_fk
FOREIGN KEY (typeMobilite_id)
REFERENCES serse.typeMobilite (typeMobilite_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.ville ADD CONSTRAINT pays_ville_fk
FOREIGN KEY (pays_id)
REFERENCES serse.pays (pays_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.entreprise_pays ADD CONSTRAINT pays_entreprise_pays_fk
FOREIGN KEY (pays_id)
REFERENCES serse.pays (pays_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.lieuSejour ADD CONSTRAINT ville_lieusejour_fk
FOREIGN KEY (ville_id)
REFERENCES serse.ville (ville_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.universite ADD CONSTRAINT ville_universite_fk
FOREIGN KEY (ville_id)
REFERENCES serse.ville (ville_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport ADD CONSTRAINT universite_rapport_fk
FOREIGN KEY (universite_id)
REFERENCES serse.universite (universite_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport ADD CONSTRAINT lieusejour_rapport_fk
FOREIGN KEY (lieuSejour_id)
REFERENCES serse.lieuSejour (lieuSejour_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport_etat ADD CONSTRAINT etat_rapport_etat_fk
FOREIGN KEY (etat_id)
REFERENCES serse.etat (etat_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport_langue ADD CONSTRAINT langue_rapport_langue_fk
FOREIGN KEY (langue_id)
REFERENCES serse.langue (langue_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport ADD CONSTRAINT utilisateur_rapport_fk
FOREIGN KEY (utilisateur_id)
REFERENCES serse.utilisateur (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.dri ADD CONSTRAINT utilisateur_dri_fk
FOREIGN KEY (utilisateur_id)
REFERENCES serse.utilisateur (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.sessionutilisateur ADD CONSTRAINT utilisateur_session_fk
FOREIGN KEY (utilisateur_id)
REFERENCES serse.utilisateur (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.administrateur ADD CONSTRAINT utilisateur_administrateur_fk
FOREIGN KEY (utilisateur_id)
REFERENCES serse.utilisateur (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport ADD CONSTRAINT dri_rapport_fk
FOREIGN KEY (dri_id)
REFERENCES serse.dri (dri_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.commentaire ADD CONSTRAINT dri_commentaire_fk
FOREIGN KEY (dri_id)
REFERENCES serse.dri (dri_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport_etat ADD CONSTRAINT dri_rapport_etat_fk
FOREIGN KEY (dri_id)
REFERENCES serse.dri (dri_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport_langue ADD CONSTRAINT rapport_rapport_langue_fk
FOREIGN KEY (rapport_id)
REFERENCES serse.rapport (rapport_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.fichier ADD CONSTRAINT rapport_fichier_fk
FOREIGN KEY (rapport_id)
REFERENCES serse.rapport (rapport_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.rapport_etat ADD CONSTRAINT rapport_rapport_etat_fk
FOREIGN KEY (rapport_id)
REFERENCES serse.rapport (rapport_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.commentaire ADD CONSTRAINT fichier_commentaire_fk
FOREIGN KEY (fichier_id)
REFERENCES serse.fichier (fichier_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE serse.administrateur OWNER TO "serse-ecn";
ALTER TABLE serse.commentaire OWNER TO "serse-ecn";
ALTER TABLE serse.continent OWNER TO "serse-ecn";
ALTER TABLE serse.domaineactivite OWNER TO "serse-ecn";
ALTER TABLE serse.dri OWNER TO "serse-ecn";
ALTER TABLE serse.entreprise OWNER TO "serse-ecn";
ALTER TABLE serse.entreprise_pays OWNER TO "serse-ecn";
ALTER TABLE serse.etat OWNER TO "serse-ecn";
ALTER TABLE serse.fichier OWNER TO "serse-ecn";
ALTER TABLE serse.langue OWNER TO "serse-ecn";
ALTER TABLE serse.lieusejour OWNER TO "serse-ecn";
ALTER TABLE serse.pays OWNER TO "serse-ecn";
ALTER TABLE serse.rapport OWNER TO "serse-ecn";
ALTER TABLE serse.rapport_etat OWNER TO "serse-ecn";
ALTER TABLE serse.rapport_langue OWNER TO "serse-ecn";
ALTER TABLE serse.sessionutilisateur OWNER TO "serse-ecn";
ALTER TABLE serse.typeexperience OWNER TO "serse-ecn";
ALTER TABLE serse.typemobilite OWNER TO "serse-ecn";
ALTER TABLE serse.typesejour OWNER TO "serse-ecn";
ALTER TABLE serse.universite OWNER TO "serse-ecn";
ALTER TABLE serse.utilisateur OWNER TO "serse-ecn";
ALTER TABLE serse.ville OWNER TO "serse-ecn";