# Stage 2: TenantViewModel (Champion)

## What it does
TenantViewModel (ui.viewmodel) takes the logic out of the Fragments:
- Holds the tenant list as LiveData (private MutableLiveData, public read-only LiveData)
- Prepares screen text with map(): tenantCountText, totalRentText, allTenantsText
- addTenant(): trims input, rejects empty fields (returns null), saves the tenant

## Why
- Data survives screen rotation
- Fragments only do UI work (show data, collect input, navigate)
- The ViewModel never holds a View or Context, so it can't leak a screen

## Libraries added
lifecycle-viewmodel-ktx, lifecycle-livedata-ktx, fragment-ktx