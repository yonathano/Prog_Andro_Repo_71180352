package id.ac.ukdw.final_71180352

class GoogleSignInActivity {
    // Configure Google Sign In
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(getString(R.string.default_web_client_id))
        .requestEmail()
        .build()

    googleSignInClient = GoogleSignIn.getClient(this, gso)
}