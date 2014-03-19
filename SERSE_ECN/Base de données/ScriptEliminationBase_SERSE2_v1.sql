-- BASE DONNEES serse : vidage des données et des tables de la base
-- Auteurs : Clara Doucoure et Audrey Pouchoulin
-- Date création : 15/04/2014
-- Date dernière modification : 15/04/2014
-- Version : 1

DROP SEQUENCE IF EXISTS serse.continent_continent_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.entreprise_entreprise_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.domaineactivite_domaineactivite_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.typeexperience_typeexperience_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.typesejour_typesejour_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.typemobilite_typemobilite_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.pays_pays_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.ville_ville_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.universite_universite_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.lieusejour_lieusejour_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.etat_etat_id_seqCASCADE;
DROP SEQUENCE IF EXISTS serse.langue_langue_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.utilisateur_utilisateur_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.administrateur_administrateur_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.session_session_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.dri_dri_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.rapport_rapport_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.fichier_fichier_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.commentaire_commentaire_id_seq CASCADE;
DROP SEQUENCE IF EXISTS serse.etat_etat_id_seq CASCADE;

DROP TABLE IF EXISTS serse.continent CASCADE;
DROP TABLE IF EXISTS serse.entreprise CASCADE;
DROP TABLE IF EXISTS serse.domaineActivite CASCADE;
DROP TABLE IF EXISTS serse.typeExperience CASCADE;
DROP TABLE IF EXISTS serse.typeSejour CASCADE;
DROP TABLE IF EXISTS serse.typeMobilite CASCADE;
DROP TABLE IF EXISTS serse.pays CASCADE;
DROP TABLE IF EXISTS serse.entreprise_pays CASCADE;
DROP TABLE IF EXISTS serse.ville CASCADE;
DROP TABLE IF EXISTS serse.universite CASCADE;
DROP TABLE IF EXISTS serse.lieuSejour CASCADE;
DROP TABLE IF EXISTS serse.etat CASCADE;
DROP TABLE IF EXISTS serse.langue CASCADE;
DROP TABLE IF EXISTS serse.utilisateur CASCADE;
DROP TABLE IF EXISTS serse.administrateur CASCADE;
DROP TABLE IF EXISTS serse.sessionutilisateur CASCADE;
DROP TABLE IF EXISTS serse.dri CASCADE;
DROP TABLE IF EXISTS serse.rapport CASCADE;
DROP TABLE IF EXISTS serse.rapport_etat CASCADE;
DROP TABLE IF EXISTS serse.fichier CASCADE;
DROP TABLE IF EXISTS serse.commentaire CASCADE;
DROP TABLE IF EXISTS serse.rapport_langue CASCADE;