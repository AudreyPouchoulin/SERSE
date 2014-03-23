-- BASE DONNEES serse : insertion de données de test
-- Auteurs : Clara Doucoure et Audrey Pouchoulin
-- Date création : 30/01/2014
-- Date dernière modification : 23/03/2014
-- Version : 5

--  des types d'expérience
INSERT INTO  serse.typeExperience (typeExperience_libelle) VALUES ('académique');
INSERT INTO  serse.typeExperience (typeExperience_libelle) VALUES ('professionnelle');

--  des types de séjour
INSERT INTO  serse.typeSejour (typeSejour_libelle) VALUES ('université');
INSERT INTO  serse.typeSejour (typeSejour_libelle) VALUES ('entreprise');

--  des types de mobilité
INSERT INTO  serse.typeMobilite (typeMobilite_libelle) VALUES ('CME');
INSERT INTO  serse.typeMobilite (typeMobilite_libelle) VALUES ('Année');
INSERT INTO  serse.typeMobilite (typeMobilite_libelle) VALUES ('Semestre');
INSERT INTO  serse.typeMobilite (typeMobilite_libelle) VALUES ('STING');
INSERT INTO  serse.typeMobilite (typeMobilite_libelle) VALUES ('Césure');
INSERT INTO  serse.typeMobilite (typeMobilite_libelle) VALUES ('Double diplôme');
INSERT INTO  serse.typeMobilite (typeMobilite_libelle) VALUES ('TFE');

--  des domaines d'activité
INSERT INTO  serse.domaineActivite (domaineActivite_libelle) VALUES ('Informatique');
INSERT INTO  serse.domaineActivite (domaineActivite_libelle) VALUES ('Mécanique');
INSERT INTO  serse.domaineActivite (domaineActivite_libelle) VALUES ('Aéronautique');

--  des continents
INSERT INTO  serse.continent (continent_nom) VALUES ('Europe');
INSERT INTO  serse.continent (continent_nom) VALUES ('Amérique');
INSERT INTO  serse.continent (continent_nom) VALUES ('Asie');
INSERT INTO  serse.continent (continent_nom) VALUES ('Afrique');
INSERT INTO  serse.continent (continent_nom) VALUES ('Océanie');

--  des pays
-- Europe
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Allemagne', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Autriche', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Belgique', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Biélorussie', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Danemark', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Espagne', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Finlande', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('France', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Grèce', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Hongrie', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Italie', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Norvège', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Pays-bas', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Pologne', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Portugal', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('République Tchèque', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Royaume-Uni', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Russie', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Slovaquie', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Solvénie', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Suède', 1);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Suisse', 1);
-- Amérique
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Brésil', 2);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Canada', 2);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Chili', 2);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Etats-Unis', 2);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Mexique', 2);
-- Asie
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Chine', 3);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Corée', 3);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Indonésie', 3);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Inde', 3);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Japon', 3);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Liban', 3);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Malaysie', 3);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Taïwan', 3);
-- Afrique
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Afrique du Sud', 4);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Algérie', 4);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Egypte', 4);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Maroc', 4);
-- Océanie
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Australie', 5);
INSERT INTO  serse.pays (pays_nom, continent_id) VALUES ('Nouvelle-Zélande', 5);

--  des villes
INSERT INTO  serse.ville (ville_nom, pays_id) VALUES ('Paris', 8);
INSERT INTO  serse.ville (ville_nom, pays_id) VALUES ('New York', 26);
INSERT INTO  serse.ville (ville_nom, pays_id) VALUES ('Los Angeles', 26);
INSERT INTO  serse.ville (ville_nom, pays_id) VALUES ('Washington', 26);
INSERT INTO  serse.ville (ville_nom, pays_id) VALUES ('Londres', 17);
INSERT INTO  serse.ville (ville_nom, pays_id) VALUES ('São Paulo', 23);
INSERT INTO  serse.ville (ville_nom, pays_id) VALUES ('Tokyo', 32);
INSERT INTO  serse.ville (ville_nom, pays_id) VALUES ('Madrid', 6);
INSERT INTO  serse.ville (ville_nom, pays_id) VALUES ('Pékin', 28);

--  des universités
INSERT INTO  serse.universite (universite_nom, ville_id) VALUES ('Columbia', 2);
INSERT INTO  serse.universite (universite_nom, ville_id) VALUES ('University of NYC', 2);
INSERT INTO  serse.universite (universite_nom, ville_id) VALUES ('London School of Economics', 5);
INSERT INTO  serse.universite (universite_nom, ville_id) VALUES ('Imperial College', 5);
INSERT INTO  serse.universite (universite_nom, ville_id) VALUES ('University College London', 5);
INSERT INTO  serse.universite (universite_nom, ville_id) VALUES ('Kings college', 5);
INSERT INTO  serse.universite (universite_nom, ville_id) VALUES ('Escola Politécnica da Universidad de São Paulo', 6);
INSERT INTO  serse.universite (universite_nom, ville_id) VALUES ('Keio University', 7);

--  des entreprises
INSERT INTO  serse.entreprise (entreprise_nom) VALUES ('Google');
INSERT INTO  serse.entreprise (entreprise_nom) VALUES ('Microsoft');
INSERT INTO  serse.entreprise (entreprise_nom) VALUES ('Airbus');

--  des états des rapports
INSERT INTO  serse.etat (etat_libelle) VALUES ('soumis');
INSERT INTO  serse.etat (etat_libelle) VALUES ('invalidé');
INSERT INTO  serse.etat (etat_libelle) VALUES ('validé');
INSERT INTO  serse.etat (etat_libelle) VALUES ('en ligne');
INSERT INTO  serse.etat (etat_libelle) VALUES ('hors ligne');

--  des langues
INSERT INTO  serse.langue (langue_nom) VALUES ('Anglais');
INSERT INTO  serse.langue (langue_nom) VALUES ('Français');
INSERT INTO  serse.langue (langue_nom) VALUES ('Espagnol');
INSERT INTO  serse.langue (langue_nom) VALUES ('Allemand');
INSERT INTO  serse.langue (langue_nom) VALUES ('Italien');
INSERT INTO  serse.langue (langue_nom) VALUES ('Portugais');
INSERT INTO  serse.langue (langue_nom) VALUES ('Chinois');
INSERT INTO  serse.langue (langue_nom) VALUES ('Japonais');

--  des utilisateurs
INSERT INTO  serse.utilisateur (utilisateur_nom, utilisateur_prenom, utilisateur_sexe, utilisateur_email) 
VALUES ('DRI', 'générique', 'M', 'International@ec-nantes.fr');
INSERT INTO  serse.utilisateur (utilisateur_nom, utilisateur_prenom, utilisateur_sexe, utilisateur_email) 
VALUES ('Vermillard', 'Sabine', 'F', 'Sabine.Vermillard@EC-Nantes.fr');
INSERT INTO  serse.utilisateur (utilisateur_nom, utilisateur_prenom, utilisateur_sexe, utilisateur_email) 
VALUES ('Bennis', 'Fouad', 'M', 'Fouad.Bennis@ec-nantes.fr');
INSERT INTO  serse.utilisateur (utilisateur_nom, utilisateur_prenom, utilisateur_sexe, utilisateur_email) 
VALUES ('Pouchoulin', 'Audrey', 'F', 'Audrey.Pouchoulin@eleves.ec-nantes.fr');
INSERT INTO  serse.utilisateur (utilisateur_nom, utilisateur_prenom, utilisateur_sexe, utilisateur_email) 
VALUES ('Doucouré', 'Clara', 'F', 'Clara.Doucoure@eleves.ec-nantes.fr');

--  des membres de la DRI
INSERT INTO  serse.dri (dri_notification_assignation, dri_notification_soumission, utilisateur_id) VALUES (false, false, 1);
INSERT INTO  serse.dri (dri_notification_assignation, dri_notification_soumission, utilisateur_id) VALUES (true, true, 2);
INSERT INTO  serse.dri (dri_notification_assignation, dri_notification_soumission, utilisateur_id) VALUES (true, true, 3);


--  des administrateurs
INSERT INTO  serse.administrateur (administrateur_notification, utilisateur_id) VALUES (true, 1);

-- (A MODIFIER)
--INSERT INTO  serse.dri_etat (etat_id, dri_id)

--  des lieux de séjour
INSERT INTO  serse.lieuSejour (ville_id, lieuSejour_adresse, lieuSejour_codePostal, lieuSejour_GPSlatitude, lieuSejour_GPSlongitude)
VALUES (6, 'Av. Prof. Almeida Prado, nº1280 - Butantã', '05508-070', 0, 0);
INSERT INTO  serse.lieuSejour (ville_id, lieuSejour_adresse, lieuSejour_codePostal, lieuSejour_GPSlatitude, lieuSejour_GPSlongitude)
VALUES (7, 'Adresse en japonais ...', 'code post', 0, 0);
INSERT INTO  serse.lieuSejour (ville_id, lieuSejour_adresse, lieuSejour_codePostal, lieuSejour_GPSlatitude, lieuSejour_GPSlongitude)
VALUES (8, 'Calle del stage', '00000', 0, 0);
INSERT INTO  serse.lieuSejour (ville_id, lieuSejour_adresse, lieuSejour_codePostal, lieuSejour_GPSlatitude, lieuSejour_GPSlongitude)
VALUES (9, 'adresse en joli chinois', 'xxxxx', 0, 0);
INSERT INTO  serse.lieuSejour (ville_id, lieuSejour_adresse, lieuSejour_codePostal, lieuSejour_GPSlatitude, lieuSejour_GPSlongitude)
VALUES (5, '10 downing street', '11111', 0, 0);


--  des rapports 
-- semestre académique université
INSERT INTO  serse.rapport (rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES ('Bresil_Semestre_Informatique_2012_apouchel', DATE '10/02/2012', DATE '10/08/2012', 1, '10Go',
3, 1, 1, 4, 2, 7, null, 1, 1);
-- semestre professionnel entreprise
INSERT INTO  serse.rapport (rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES ('Japon_Semestre_Mecanique_2012_cdoucour', DATE '10/02/2012', DATE '10/08/2012', 1, '10Go',
3, 2, 2, 5, 2, null, 3, 2, 2);

-- cesure académique université
INSERT INTO  serse.rapport (rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES ('Bresil_Cesure_Informatique_2014_apouchel', DATE '01/09/2014', DATE '01/09/2015', 1, '10Go',
5, 1, 1, 4, 2, 7, null, 1, 1);
-- cesure professionnel université
INSERT INTO  serse.rapport (rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES ('Japon_Cesure_Mecanique_2014_cdoucour', DATE '01/09/2014', DATE '01/09/2015', 1, '10Go',
5, 1, 2, 5, 2, 8, null, 2, 2);

-- CME professionnel entreprise
INSERT INTO  serse.rapport (rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES ('Espagne_CME_Informatique_2013_cdoucour', DATE '10/07/2013', DATE '10/08/2013', 1, '1Go',
1, 2, 2, 5, 2, null, 1, 1, 3);
-- STING professionnel entreprise
INSERT INTO  serse.rapport (rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES ('Chine_STING_Informatique_2013_cdoucour', DATE '10/05/2013', DATE '01/09/2013', 1, '1Go',
4, 2, 2, 5, 2, null, 2, 1, 4);
-- TFE professionnel entreprise
INSERT INTO  serse.rapport (rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES ('Chine_TFE_Informatique_2013_cdoucour', DATE '10/05/2013', DATE '01/09/2013', 1, '1Go',
7, 2, 2, 5, 2, null, 2, 1, 4);

-- DD académique université
INSERT INTO  serse.rapport (rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES ('Royaume-Uni_DoubleDiplome_Informatique_2020_apouchel', DATE '01/09/2020', DATE '01/09/2021', 1, '1Go',
6, 1, 1, 4, 2, 3, null, 1, 5);
-- Année académique université
INSERT INTO  serse.rapport (rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES ('Royaume-Uni_Annee_Informatique_2020_cdoucour', DATE '01/09/2020', DATE '01/09/2021', 1, '1Go',
2, 1, 1, 5, 2, 4, null, 1, 5);

--  d'association de langue(s) à un rapport
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (1,6);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (2,1);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (3,6);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (4,1);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (5,3);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (6,7);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (7,7);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (8,1);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (9,1);

--  d'association d'état à un rapport
INSERT INTO  serse.rapport_etat (rapport_id, etat_id, dri_id, rapport_etat_dateheure) VALUES (1,4,2,CURRENT_TIMESTAMP);
INSERT INTO  serse.rapport_etat (rapport_id, etat_id, dri_id, rapport_etat_dateheure) VALUES (2,4,2,CURRENT_TIMESTAMP);
INSERT INTO  serse.rapport_etat (rapport_id, etat_id, dri_id, rapport_etat_dateheure) VALUES (3,4,2,CURRENT_TIMESTAMP);
INSERT INTO  serse.rapport_etat (rapport_id, etat_id, dri_id, rapport_etat_dateheure) VALUES (4,4,2,CURRENT_TIMESTAMP);
INSERT INTO  serse.rapport_etat (rapport_id, etat_id, dri_id, rapport_etat_dateheure) VALUES (5,4,2,CURRENT_TIMESTAMP);
INSERT INTO  serse.rapport_etat (rapport_id, etat_id, dri_id, rapport_etat_dateheure) VALUES (6,4,3,CURRENT_TIMESTAMP);
INSERT INTO  serse.rapport_etat (rapport_id, etat_id, dri_id, rapport_etat_dateheure) VALUES (7,4,3,CURRENT_TIMESTAMP);
INSERT INTO  serse.rapport_etat (rapport_id, etat_id, dri_id, rapport_etat_dateheure) VALUES (8,4,3,CURRENT_TIMESTAMP);
INSERT INTO  serse.rapport_etat (rapport_id, etat_id, dri_id, rapport_etat_dateheure) VALUES (9,4,3,CURRENT_TIMESTAMP);

--  d'association des entreprises à des pays
INSERT INTO  serse.entreprise_pays (entreprise_id, pays_id) VALUES (1,26);
INSERT INTO  serse.entreprise_pays (entreprise_id, pays_id) VALUES (1,17);
INSERT INTO  serse.entreprise_pays (entreprise_id, pays_id) VALUES (2,26);
INSERT INTO  serse.entreprise_pays (entreprise_id, pays_id) VALUES (2,17);

--  des commentaires
-- INSERT INTO  serse.commentaire (commentaire_dateHeure, commentaire_contenu, fichier_id, dri_id);

--  des sessions
-- INSERT INTO  serse.sessionutilisateur (session_adresseIP, session_dateHeureDebut, session_dateHeureFin, utilisateur_id)