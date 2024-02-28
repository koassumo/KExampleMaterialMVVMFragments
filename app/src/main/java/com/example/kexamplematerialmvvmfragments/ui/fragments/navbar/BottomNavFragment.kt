import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kexamplematerialmvvmfragments.databinding.NavBarFragmentBinding


class BottomNavFragment : Fragment() {

    private var _binding: NavBarFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = NavBarFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        // Ваш код здесь, используйте binding.bottomNavigationView вместо bottom_navigation_view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
