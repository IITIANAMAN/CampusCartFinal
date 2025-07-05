package ar.com.Amanmeena.campuscart.ViewModels

import androidx.lifecycle.ViewModel
import ar.com.Amanmeena.campuscart.UserData.UserData
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class AuthenticationViewModel: ViewModel() {
    private val auth = Firebase.auth
    private val FireStore = Firebase.firestore
    fun login(email: String,password: String,onResult: (Boolean, String?)-> Unit)
    {
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful)
            {
                onResult(true,null)
            }else
            {
                onResult(false, "Something went Wrong :)")
            }
        }

    }
    fun signIn(email : String, password: String, name: String,onResult: (Boolean, String?)-> Unit)
    {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful) {
                var userId =it.result?.user?.uid
                val user = UserData(name, email,userId!!)
                FireStore.collection("users").document(userId).set(user)
                    .addOnCompleteListener {dbtask->
                        if(dbtask.isSuccessful)
                        {
                            onResult(true,null)
                        }else
                        {
                            onResult(false, "Something went Wrong :)")
                        }

                    }
            }else
            {
                onResult(false, it.exception?.localizedMessage.toString())
            }
        }
    }
}