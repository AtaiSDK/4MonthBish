package com.example.a4monthbish.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a4monthbish.data.Car
import com.example.a4monthbish.databinding.FragmentNotificationsBinding
import com.example.a4monthbish.ui.notifications.adapter.CarAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class NotificationsFragment : Fragment() {

    private val db = Firebase.firestore
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!
    private val adapter = CarAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        db.collection(FirebaseAuth.getInstance().currentUser?.uid.toString())
            .get().addOnSuccessListener {
                val list = it.toObjects(Car::class.java)
                adapter.setCar(list)

            }.addOnFailureListener {
                Log.e("ololo", "onViewCreated: $it")
            }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}