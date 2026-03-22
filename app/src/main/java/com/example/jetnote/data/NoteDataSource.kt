package com.example.jetnote.data

import com.example.jetnote.model.Note

class NoteDataSource {

    fun loadNotes(): List<Note>{
        return listOf(
            Note(title = "Réunion d'équipe", description = "Préparer le rapport mensuel pour la réunion de lundi matin"),
            Note(title = "Courses", description = "Acheter du pain, du lait, des œufs et des légumes pour la semaine"),
            Note(title = "Sport", description = "Aller courir 5km au parc, ne pas oublier les écouteurs"),
            Note(title = "Projet Android", description = "Terminer l'implémentation du ViewModel et tester les fonctionnalités"),
            Note(title = "Anniversaire Maman", description = "Acheter un cadeau et réserver un restaurant pour samedi soir"),
            Note(title = "Lecture", description = "Finir le chapitre 5 du livre Clean Architecture de Robert Martin"),
            Note(title = "Rendez-vous médecin", description = "Consultation générale à 14h30, apporter la carte d'assurance maladie"),
            Note(title = "Paiement loyer", description = "Effectuer le virement bancaire avant le 5 du mois"),
            Note(title = "Idée application", description = "Créer une app de gestion de budget personnel avec graphiques"),
            Note(title = "Révisions examen", description = "Revoir les chapitres sur les algorithmes de tri et la complexité")
        )
    }
}