SELECT rapport_nom, rapport_datedebut, rapport_datefin, pays_nom, ville_nom, domaineActivite_libelle, typeMobilite_libelle, langue_nom
FROM serse.rapport
LEFT JOIN serse.lieuSejour ON serse.rapport.lieuSejour_id = serse.lieuSejour.lieuSejour_id
LEFT JOIN serse.ville ON serse.lieuSejour.ville_id = serse.ville.ville_id
LEFT JOIN serse.pays ON serse.ville.pays_id = serse.pays.pays_id
LEFT JOIN serse.continent ON serse.pays.continent_id = serse.continent.continent_id
LEFT JOIN serse.domaineActivite ON serse.rapport.domaineActivite_id = serse.domaineActivite.domaineActivite_id
LEFT JOIN serse.typeExperience ON serse.rapport.typeExperience_id = serse.typeExperience.typeExperience_id
LEFT JOIN serse.typeMobilite ON serse.rapport.typeMobilite_id = serse.typeMobilite.typeMobilite_id
LEFT JOIN serse.typeSejour ON serse.rapport.typeSejour_id = serse.typeSejour.typeSejour_id
LEFT JOIN serse.rapport_langue ON serse.rapport.rapport_id = serse.rapport_langue.rapport_id
LEFT JOIN serse.langue ON serse.rapport_langue.langue_id = serse.langue.langue_id
LEFT JOIN serse.universite ON serse.rapport.universite_id = serse.universite.universite_id
LEFT JOIN serse.entreprise ON serse.rapport.entreprise_id = serse.entreprise.entreprise_id
WHERE continent_nom = 'Europe'
ORDER BY rapport_nom;

-- REQUETE PERMETTANT DE COMPTER LE NOMBRE DE RAPPORTS EN ATTENTE DE VALIDATION
SELECT count(DISTINCT rapport.rapport_id)
FROM serse.rapport, serse.rapport_etat
WHERE (serse.rapport.rapport_id=serse.rapport_etat.rapport_id AND rapport_etat.etat_id=1);

-- REQUETE PERMETTANT DE COMPTER LE NOMBRE DE RAPPORTS EN ATTENTE DE MISE EN LIGE (VALIDES MAIS PAS ENCORE MIS EN LIGNE)
SELECT count(DISTINCT rapport.rapport_id)
FROM serse.rapport, serse.rapport_etat
WHERE (serse.rapport.rapport_id=serse.rapport_etat.rapport_id AND rapport_etat.etat_id=3);

--
-- REQUETE POUR CREER UN NOUVEAU TYPE D'OPTION
CREATE SEQUENCE serse.options_options_id_seq;

CREATE TABLE serse.options
(
  options_id integer NOT NULL DEFAULT nextval('serse.typeexperience_typeexperience_id_seq'::regclass),
  options_libelle character varying(50) NOT NULL,
  CONSTRAINT options_id_pk PRIMARY KEY (options_id)
);

ALTER SEQUENCE serse.options_options_id_seq OWNER TO "serse-ecn";

ALTER TABLE serse.options ADD CONSTRAINT options_rapport_fk
FOREIGN KEY (options_id)
REFERENCES serse.options (options_id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

-- REQUETE POUR MODIFIER LES PARAMETRES DE RECEPTION D'EMAILS DE NOTIFICATIONS
-- Assignation a relecture
UPDATE serse.dri SET dri_notification_assignation='FALSE' where dri.dri_id=1;
UPDATE serse.dri SET dri_notification_assignation='TRUE' where dri.dri_id=1;

-- Soumission d'un nouveau rapport
UPDATE serse.dri SET dri_notification_soumission='TRUE' where dri.dri_id=1;
UPDATE serse.dri SET dri_notification_soumission='TRUE' where dri.dri_id=1;

-- RECHERCHES DES RAPPORTS SOUMIS EN ATTENTE DE VALIDATION
SELECT rapport.rapport_nom, fichier.fichier_dateHeure, pays.pays_nom, etat.etat_libelle, typeExperience.typeExperience_libelle, dri.dri_id
	from serse.rapport, serse.lieuSejour, serse.ville, serse.pays, serse.rapport_etat, serse.etat, serse.fichier, serse.typeExperience,
	serse.dri
	where (rapport.rapport_id=fichier.rapport_id 
		AND rapport.lieuSejour_id=lieuSejour.lieuSejour_id
		AND lieuSejour.ville_id=ville.ville_id
		AND ville.pays_id=pays.pays_id
		AND rapport.rapport_id=rapport_etat.rapport_id
		AND rapport_etat.etat_id=etat.etat_id
		AND rapport.typeExperience_id=typeExperience.typeExperience_id
		AND rapport.dri_id=dri.dri_id
		AND etat_libelle='soumis');

-- Test insertion nouvelle option
INSERT INTO serse.pays (pays_id, pays_nom, continent_id,etatOption_id) VALUES (43, 'Ukraine', 1, 1);

